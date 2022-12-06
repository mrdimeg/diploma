import React from "react";
import {
  MainCardsContainer,
  ContainerAllCorses,
  Container,
  ContainerCors,
  CorsPic,
  CorsName,
  CorseDesc,
  StyledLink,
  BackContainer,
} from "./style";

export const MainCardsCorses = () => {
  return (
    <MainCardsContainer>
      <Container>
        <ContainerAllCorses>
          <ContainerCors>
            <CorsPic
              src="https://static.tildacdn.com/tild6437-6637-4639-b433-383262366537/Frame_4-min.png"
              alt="Corse"
            />
            <CorsName>TeachMeSkills</CorsName>
            <CorseDesc>
              TeachMeSkills - это школа программирования, где мы научим тебя
              востребованным сегодня знаниям.
            </CorseDesc>
          </ContainerCors>

          <ContainerCors>
            <CorsPic
              src="https://thumb.tildacdn.com/tild6132-3034-4837-a563-666334336230/-/resize/720x/-/format/webp/2_41.jpg"
              alt="Corse"
            />
            <CorsName>Art Platform</CorsName>
            <CorseDesc>
              Наши курсы рисования и живописи предполагают обучение любой
              желающий вне зависимости от возрастных рамок или наличия начальных
              навыков и умений.
            </CorseDesc>
          </ContainerCors>
          <ContainerCors>
            <CorsPic
              src="https://kolokolschool.by/system/attachments/files/000/006/327/original/IMG_8605.jpg?1574418812"
              alt="Corse"
            />
            <CorsName>Kolokol</CorsName>
            <CorseDesc>
              Мастера гончарной школы «Колокол» с радостью поделятся с вами
              собственным опытом, и научат всему необходимому для дальнейшего
              развития в гончарстве.
            </CorseDesc>
          </ContainerCors>
          <ContainerCors>
            <CorsPic
              src="https://static.tildacdn.com/tild3737-3666-4635-b964-646164353866/7F3260BC-8AC9-4A66-8.jpg"
              alt="Corse"
            />
            <CorsName>Yoga Place</CorsName>
            <CorseDesc>
              Добро пожаловать в Yoga Place – место для йоги, пространство для
              души. Для нас практика йоги – это не просто физкультура и не
              мистический ритуал.
            </CorseDesc>
          </ContainerCors>
        </ContainerAllCorses>
        <StyledLink to="/all-corses"> Все Курсы</StyledLink>
      </Container>

      <BackContainer />
    </MainCardsContainer>
  );
};
