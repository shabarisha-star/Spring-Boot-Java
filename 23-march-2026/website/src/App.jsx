import Header from "./Components/Header";
import Hero from "./Components/Hero";
import SearchBar from "./Components/SearchBar";

function App() {
  return (
    <>
      <div className=" via-blue-300 to-white min-h-screen">
        <div className="bg-white text-black">
          <Header />
        </div>
        <div className="bg-white text-black">
          <Hero />
        </div>
        <div>
          <SearchBar />
        </div>
      </div>
    </>
  );
}

export default App;
