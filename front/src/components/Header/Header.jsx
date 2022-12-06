import React from "react";
import { StyledHeader, StyledLink, Logo, ContainerTitle, Title } from "./style";
import { Nav } from "../Nav/Nav";
import logo from "../../assets/logo.png";

export const Header = () => {
  return (
    <StyledHeader>
      <ContainerTitle>
        <Logo src={logo} alt="Logo" />
        <Title>Name.</Title>
      </ContainerTitle>
      <Nav />
      <StyledLink to="/login">Админ</StyledLink>
    </StyledHeader>
  );
};
