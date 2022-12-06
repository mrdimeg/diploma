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

export const ArtCorses = () => {
  return (
    <Container>
      <ContainerResult>
        <TitleRez>Результат:</TitleRez>
        <DescRez>
          Богатое воображение – Ваш «конек». Так «оседлайте» на выбор фотодело,
          рисование, создание сайтов, карвинг, написание стихов и прозы.
        </DescRez>
        <VarRez>Варианты творческих хобби:</VarRez>
      </ContainerResult>
      <StyledCorsesList>
        <CorseCardContainer>
          <Image
            src="https://kolokolschool.by/system/attachments/files/000/006/327/original/IMG_8605.jpg?1574418812"
            alt="Corse"
          />
          <InfoContainer>
            <CorseName>Kolokol</CorseName>
            <CorsesUrl href="https://kolokolschool.by/">
              https://kolokolschool.by/
            </CorsesUrl>
            <CorseAdress>Ангарская, 26"</CorseAdress>
            <CorseDesc>
              Мастера гончарной школы «Колокол» с радостью поделятся с вами
              собственным опытом, и научат всему необходимому для дальнейшего
              развития в гончарстве.
            </CorseDesc>
          </InfoContainer>
        </CorseCardContainer>
      </StyledCorsesList>
    </Container>
  );
};
