function ListDisplay(){
    const friut=["apple","banana","papaya"];

    return(
        <>
        <h2>List Using Map</h2>
        {friut.map((friut) => (
            <div>{friut}</div>
        ))}
        </>
    );
}
export default ListDisplay;