import axios from "axios";

const BASE_URL = "http://localhost:1010/todos";

axios.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export const getAllTodos = async () => {
  const response = await axios.get(BASE_URL);
  return response.data.data;
};

export const createTodo = async (todoData) => {
  const response = await axios.post(BASE_URL, todoData);
  return response.data.data;
};

export const deleteTodo = async (id) => {
  await axios.delete(`${BASE_URL}/${id}`);
};

export const getTodoById = async (id) => {
  const response = await axios.get(`${BASE_URL}/${id}`);
  return response.data.data;
};

export const updateTodo = async (id, todoData) => {
  const response = await axios.put(`${BASE_URL}/${id}`, todoData);
  return response.data.data;
};