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

export const AdvenCorses = () => {
  return (
    <Container>
      <ContainerResult>
        <TitleRez>Результат:</TitleRez>
        <DescRez>
          Ваша стихия – адреналин, а главная черта – любознательность. Нужно
          удовлетворить оба этих начала. Подойдут путешествия, экстремальные
          виды спорта, рыбалка, охота.
        </DescRez>
        <VarRez>Несколько хобби, которые посвящены поискам приключений:</VarRez>
      </ContainerResult>
      <StyledCorsesList>
        <CorseCardContainer>
          <Image src="https://deeptrip.by/static/622805230.jpg" alt="Course" />
          <InfoContainer>
            <CorseName>Sea Pegas</CorseName>
            <CorsesUrl href="https://seapegas.com/">
              https://seapegas.com/
            </CorsesUrl>
            <CorseAdress>Победителей 109</CorseAdress>
            <CorseDesc>
              Самый верный путь получить доступ в подводный мир – пройти курсы
              дайвинга под непосредственным руководством опытного инструктора, в
              авторитетном, проверенном месте.
            </CorseDesc>
          </InfoContainer>
        </CorseCardContainer>
      </StyledCorsesList>
    </Container>
  );
};
