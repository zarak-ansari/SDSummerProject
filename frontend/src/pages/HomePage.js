import { setAuthToken } from "../helpers/setAuthToken";
import axios from "axios";
import React from "react";

function HomePage() {
    let message = ""
    localStorage.getItem("token") ? message = localStorage.getItem("token") : message = "not found"

    function logout() {
        setAuthToken()
        localStorage.removeItem("token")
        window.location.href = "/login"
    }

    const [user, setUser] = React.useState("")

    axios.get("http://localhost:8080/api/user/info")
        .then(response => {
            //get token from response
            setUser(response.data.email)
        })
        .catch(err => console.log(err));


    return (
        <div>
            <h1>Home Page</h1>
            <p>{message}</p>
            <p>{user}</p>
            <button onClick={logout}>Log Out</button>
        </div>
    );
}

export default HomePage;