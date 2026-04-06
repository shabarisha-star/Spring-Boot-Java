import axios from "axios";

const API_URL = "http://localhost:8080/api/todos";

const getAuthHeader = () => ({
  headers: { Authorization: `Bearer ${localStorage.getItem("token")}` },
});

export const getAllTodos = async () => axios.get(API_URL, getAuthHeader());
export const getTodoById = async (id) => axios.get(`${API_URL}/${id}`, getAuthHeader());
export const createTodo = async (todo) => axios.post(API_URL, todo, getAuthHeader());
export const updateTodo = async (id, todo) => axios.put(`${API_URL}/${id}`, todo, getAuthHeader());
export const deleteTodo = async (id) => axios.delete(`${API_URL}/${id}`, getAuthHeader());
export const toggleComplete = async (id) => axios.patch(`${API_URL}/${id}/complete`, {}, getAuthHeader());