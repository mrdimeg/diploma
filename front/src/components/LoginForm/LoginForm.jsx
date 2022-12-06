import React from "react";
import { useState } from "react";
import axios from "axios";
import {
  StyledForm,
  FormTitle,
  Container,
  StyledInput,
  StyledButton,
} from "./style";

export const LoginForm = () => {
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [submitted, setSubmitted] = useState(false);
  const [error, setError] = useState(false);

  const handleName = (e) => {
    setName(e.target.value);
    setSubmitted(false);
  };

  const handlePassword = (e) => {
    setPassword(e.target.value);
    setSubmitted(false);
  };

  let config = {
    headers: {
      "Content-Type": "application/json",
      "Access-Control-Allow-Methods": "POST",
    },
  };

  let data = {
    username: name,
    password: password,
  };

  async function handleSubmit(event) {
    event.preventDefault();
    try {
      await axios.post("http://3.83.175.175:8080/user/login", data, config);
      if (name === "" || password === "") {
        setError(true);
      } else {
        alert("User Registation Successfully");
        setSubmitted(true);
        setError(false);
        setName("");
      }
    } catch (err) {
      alert("User Registation Failed");
    }
  }

  const successMessage = () => {
    return (
      <div
        className="success"
        style={{
          display: submitted ? "" : "none",
        }}
      >
        <h1>User {name} successfully registered!!</h1>
      </div>
    );
  };

  const errorMessage = () => {
    return (
      <div
        className="error"
        style={{
          display: error ? "" : "none",
        }}
      >
        <h1>Please enter all the fields</h1>
      </div>
    );
  };

  return (
    <Container>
      <div>
        <FormTitle>Вход для администратора</FormTitle>
      </div>
      <div className="messages">
        {errorMessage()}
        {successMessage()}
      </div>

      <StyledForm>
        <StyledInput
          onChange={handleName}
          value={name}
          type="text"
          placeholder="Введите ваш name"
        />
        <StyledInput
          placeholder="Введите ваш пароль"
          onChange={handlePassword}
          value={password}
          type="password"
        />

        <StyledButton onClick={handleSubmit} className="btn" type="submit">
          Submit
        </StyledButton>
      </StyledForm>
    </Container>
  );
};
