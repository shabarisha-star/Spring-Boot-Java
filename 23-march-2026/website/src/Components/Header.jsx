function Header(){
    return (
      <div>
        <div className="flex text-xl justify-between items-center gap-8 py-6 px-12 font-bold">
          <div className="flex ">
            <div className=" italic font-serif">Sky</div>
            <div>EXplorer</div>
          </div>
          <div className="flex  gap-5 ">
            <div>Features</div>
            <div>Method</div>
            <div>Pricing</div>
            <div>Changelog</div>
          </div>
          <div className="flex  gap-5">
            <button className="px-4 py-1 border  rounded-xl text-white bg-linear-to-r from-gray-800 to-black shadow-md">
              Login
            </button>
          </div>
        </div>
      </div>
    );

}
export default Header;