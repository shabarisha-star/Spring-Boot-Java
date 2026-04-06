import { Link } from "react-router-dom";

function Home() {
  return (
    <div className="min-h-[80vh] flex items-center justify-center">
      <div className="text-center max-w-lg">
        <div className="text-7xl mb-6">✅</div>
        <h1 className="text-4xl font-bold text-gray-800 mb-4">Welcome to TodoApp</h1>
        <p className="text-gray-500 text-lg mb-2">Stay organized. Get things done.</p>
        <p className="text-gray-400 text-sm mb-10">
          Create an account to start managing your personal todos — only you can see your tasks.
        </p>
        <div className="flex items-center justify-center gap-4">
          <Link
            to="/register"
            className="bg-indigo-600 hover:bg-indigo-700 text-white font-semibold px-8 py-3 rounded-xl transition text-sm"
          >
            Get Started — Register
          </Link>
          <Link
            to="/login"
            className="bg-white hover:bg-gray-50 border border-gray-300 text-gray-700 font-semibold px-8 py-3 rounded-xl transition text-sm"
          >
            Login
          </Link>
        </div>
      </div>
    </div>
  );
}

export default Home;
