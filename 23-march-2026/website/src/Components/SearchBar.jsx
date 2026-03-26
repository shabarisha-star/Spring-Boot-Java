function SearchBar() {
  return (
    <div className="flex flex-col items-center mt-10">
      {/* TOP OPTIONS */}
      <div className="flex text-sm text-gray-600 mb-3">
        <div>Round trip ▾</div>
        <div>Passengers ▾</div>
      </div>

      {/* MAIN SEARCH BAR */}
      <div className="flex items-center gap-3">
        {/* FROM */}
        <div className="bg-white px-6 py-4 rounded-xl shadow-sm w-62.5">
          <p className="text-xs text-gray-400">From</p>
          <p className="font-medium">Warsaw, Poland</p>
        </div>

        {/* SWAP BUTTON */}
        <div className="bg-gray-100 p-2 rounded-full shadow">⇄</div>

        {/* TO */}
        <div className="bg-white px-6 py-4 rounded-xl shadow-sm w-62.5">
          <p className="text-xs text-gray-400">To</p>
          <p className="font-medium">Bangkok, Thailand</p>
        </div>

        {/* SEARCH BUTTON */}
        <button className="px-8 py-4 rounded-xl text-white bg-linear-to-r from-gray-800 to-black shadow-md">
          Search
        </button>
      </div>
    </div>
  );
}

export default SearchBar;
