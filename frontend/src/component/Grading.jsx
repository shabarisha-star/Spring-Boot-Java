import { useState } from "react";

function Grading(){
    const [persentage,setPersentage]=useState("");
    const [grade,setGrade]=useState("");

    const handleGrade = () =>{
        if(persentage<=100 && persentage>=90 ){
            setGrade("A");
        }else if(persentage>=75 && persentage<=90){
            setGrade("B");
        }else if(persentage>=50 && persentage<=75){
            setGrade("c");
        }else if(persentage>=30 && persentage<=50){
            setGrade("D");
        }else if(persentage<30){
            setGrade("Fail");
        }else{
            setGrade("Invalied Input");
        }
    }

    return (
        <>
       <div>
        <h2>Now your Grade</h2>
        <input type="number" placeholder="Enter Persentage" onChange={(e) => setPersentage(e.target.value)}/>
        <br>
        </br>
        <button onClick={handleGrade}>Submit</button>
        <p>Grade:{grade}</p>
       </div>
        </>
    );

}
export default Grading;