import { Routes, Route, Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import TodoList from "./pages/TodoList";
import CreateTodo from "./pages/CreateTodo";
import EditTodo from "./pages/EditTodo";
import Register from "./pages/Register";
import Login from "./pages/Login";
import Home from "./pages/Home";
import { logout, isLoggedIn, getUsername } from "./services/authService";

function App() {
  const navigate = useNavigate();
  const [loggedIn, setLoggedIn] = useState(isLoggedIn());

  const handleLogout = () => {
    logout();
    setLoggedIn(false);
    navigate("/login");
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <nav className="bg-indigo-700 shadow-lg px-8 py-4 flex items-center justify-between">
        <div className="flex items-center gap-2">
          <span className="text-white text-2xl font-bold tracking-wide">✅ TodoApp</span>
        </div>
        {loggedIn ? (
          <div className="flex items-center gap-6">
            <Link to="/" className="text-indigo-100 hover:text-white font-medium transition">Home</Link>
            <Link to="/create" className="text-indigo-100 hover:text-white font-medium transition">+ Create</Link>
            <div className="flex items-center gap-3 ml-4 border-l border-indigo-500 pl-4">
              <span className="text-indigo-200 text-sm">👤 {getUsername()}</span>
              <button
                onClick={handleLogout}
                className="bg-red-500 hover:bg-red-600 text-white text-sm px-4 py-1.5 rounded-full transition"
              >
                Logout
              </button>
            </div>
          </div>
        ) : (
          <div className="flex items-center gap-4">
            <Link to="/login" className="text-indigo-100 hover:text-white font-medium transition">Login</Link>
            <Link
              to="/register"
              className="bg-white text-indigo-700 hover:bg-indigo-50 font-semibold px-4 py-1.5 rounded-full transition"
            >
              Register
            </Link>
          </div>
        )}
      </nav>

      <main className="max-w-5xl mx-auto px-4 py-8">
        <Routes>
          <Route path="/" element={loggedIn ? <TodoList /> : <Home />} />
          <Route path="/create" element={<CreateTodo />} />
          <Route path="/edit/:id" element={<EditTodo />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
        </Routes>
      </main>
    </div>
  );
}

export default App;
