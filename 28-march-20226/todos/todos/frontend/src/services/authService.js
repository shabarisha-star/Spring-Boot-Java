import axios from "axios";

const AUTH_URL = "http://localhost:8080/api/auth";

export const register = async (username, password) => {
  return await axios.post(`${AUTH_URL}/register`, { username, password });
};

export const login = async (username, password) => {
  return await axios.post(`${AUTH_URL}/login`, { username, password });
};

export const logout = () => {
  localStorage.removeItem("token");
  localStorage.removeItem("username");
};

export const getUsername = () => localStorage.getItem("username");
export const isLoggedIn = () => !!localStorage.getItem("token");
