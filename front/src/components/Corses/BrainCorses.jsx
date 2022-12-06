import React from "react";
import {
  Image,
  StyledCorsesList,
  CorseCardContainer,
  InfoContainer,
  CorseName,
  CorsesUrl,
  CorseDesc,
  CorseAdress,
  ContainerResult,
  TitleRez,
  DescRez,
  VarRez,
  Container,
} from "./style";

export const BrainCorses = () => {
  return (
    <Container>
      <ContainerResult>
        <TitleRez>Результат:</TitleRez>
        <DescRez>
          Вы нуждаетесь в максимальном интеллектуальном напряжении. Подходящие
          хобби - шахматы, изучение иностранных языков, доказательство теорем,
          разгадывание шарад и ребусов.
        </DescRez>
        <VarRez>Список интеллектуальных хобби:</VarRez>
      </ContainerResult>
      <StyledCorsesList>
        <CorseCardContainer>
          <Image
            src="https://static.tildacdn.com/tild6437-6637-4639-b433-383262366537/Frame_4-min.png"
            alt="Corse"
          />
          <InfoContainer>
            <CorseName>TeachMeSkills</CorseName>
            <CorsesUrl href="https://teachmeskills.by/">
              https://teachmeskills.by/
            </CorsesUrl>
            <CorseAdress>Тимирязева 67</CorseAdress>
            <CorseDesc>
              TeachMeSkills - это школа программирования, где мы научим тебя
              востребованным сегодня знаниям.
            </CorseDesc>
          </InfoContainer>
        </CorseCardContainer>
      </StyledCorsesList>
    </Container>
  );
};
