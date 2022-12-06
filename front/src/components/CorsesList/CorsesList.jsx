import React from "react";
import { StyledCorsesList } from "./style";
import { CorseCard } from "../CorseCard/CorseCard";
import corsesData from "../../corses-data.json";

export const CorsesList = () => {
  return (
    <StyledCorsesList>
      {corsesData.map((corse) => {
        return <CorseCard corse={corse} />;
      })}
    </StyledCorsesList>
  );
};
