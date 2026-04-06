import { useEffect, useState } from "react";
import { getAllTodos, deleteTodo, toggleComplete } from "../services/todoService";
import { useNavigate } from "react-router-dom";

function TodoList() {
  const navigate = useNavigate();
  const [todos, setTodos] = useState([]);

  const fetchTodos = async () => {
    const response = await getAllTodos();
    setTodos(response.data);
  };

  useEffect(() => {
    fetchTodos();
  }, []);

  const handleDelete = async (id) => {
    await deleteTodo(id);
    fetchTodos();
  };

  const handleToggle = async (id) => {
    await toggleComplete(id);
    fetchTodos();
  };

  return (
    <div>
      <div className="flex items-center justify-between mb-6">
        <h2 className="text-2xl font-bold text-gray-800">My Todos</h2>
        <span className="text-sm text-gray-500">{todos.length} task{todos.length !== 1 ? "s" : ""}</span>
      </div>

      {todos.length === 0 ? (
        <div className="text-center py-20 text-gray-400">
          <p className="text-5xl mb-4">📋</p>
          <p className="text-lg">No todos yet. Click <strong>+ Create</strong> to add one!</p>
        </div>
      ) : (
        <div className="bg-white rounded-2xl shadow overflow-hidden">
          <table className="w-full text-sm text-left">
            <thead className="bg-indigo-600 text-white text-xs uppercase tracking-wider">
              <tr>
                <th className="px-6 py-4">#</th>
                <th className="px-6 py-4">Title</th>
                <th className="px-6 py-4">Description</th>
                <th className="px-6 py-4">Status</th>
                <th className="px-6 py-4 text-center">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-100">
              {todos.map((todo) => (
                <tr key={todo.id} className={`hover:bg-gray-50 transition ${todo.completed ? "opacity-60" : ""}`}>
                  <td className="px-6 py-4 text-gray-400 font-mono">{todo.id}</td>
                  <td className={`px-6 py-4 font-medium text-gray-800 ${todo.completed ? "line-through" : ""}`}>
                    {todo.title}
                  </td>
                  <td className="px-6 py-4 text-gray-500">{todo.description}</td>
                  <td className="px-6 py-4">
                    <span className={`px-3 py-1 rounded-full text-xs font-semibold ${
                      todo.completed
                        ? "bg-green-100 text-green-700"
                        : "bg-yellow-100 text-yellow-700"
                    }`}>
                      {todo.completed ? "✅ Done" : "⏳ Pending"}
                    </span>
                  </td>
                  <td className="px-6 py-4">
                    <div className="flex items-center justify-center gap-2">
                      <button
                        onClick={() => handleToggle(todo.id)}
                        className={`px-3 py-1.5 rounded-lg text-xs font-semibold transition ${
                          todo.completed
                            ? "bg-gray-100 hover:bg-gray-200 text-gray-600"
                            : "bg-green-500 hover:bg-green-600 text-white"
                        }`}
                      >
                        {todo.completed ? "Undo" : "Done"}
                      </button>
                      <button
                        onClick={() => navigate(`/edit/${todo.id}`)}
                        className="px-3 py-1.5 rounded-lg text-xs font-semibold bg-indigo-500 hover:bg-indigo-600 text-white transition"
                      >
                        Edit
                      </button>
                      <button
                        onClick={() => handleDelete(todo.id)}
                        className="px-3 py-1.5 rounded-lg text-xs font-semibold bg-red-500 hover:bg-red-600 text-white transition"
                      >
                        Delete
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default TodoList;
