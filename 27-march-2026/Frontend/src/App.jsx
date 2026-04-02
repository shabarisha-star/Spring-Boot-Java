import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./src/pages/Login";
import ProtectedRoute from "./src/components/ProtectedRoute";
import TodoList from "./src/pages/TodoList";
import CreateTodo from "./src/pages/CreateTodo";
import EditTodo from "./src/pages/EditTodo";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>

        <Route path="/login" element={<Login />} />

        <Route
          path="/"
          element={
            <ProtectedRoute>
              <TodoList />
            </ProtectedRoute>
          }
        />

        <Route
          path="/create"
          element={
            <ProtectedRoute>
              <CreateTodo />
            </ProtectedRoute>
          }
        />

        <Route
          path="/edit/:id"
          element={
            <ProtectedRoute>
              <EditTodo />
            </ProtectedRoute>
          }
        />

      </Routes>
    </BrowserRouter>
  );
}