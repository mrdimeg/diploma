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

export const HandCorses = () => {
  return (
    <Container>
      <ContainerResult>
        <TitleRez>Результат:</TitleRez>
        <DescRez>
          Ваша задача – внести в жизнь максимум уюта и тепла. Идеальные варианты
          - шитье, вязание, кулинария, вышивание, цветоводство.
        </DescRez>
        <VarRez>
          Список хобби посвященных рукоделию и создание интересных вещей своими
          руками:
        </VarRez>
      </ContainerResult>
      <StyledCorsesList>
        <CorseCardContainer>
          <Image
            src="https://static.tildacdn.com/tild3866-3330-4564-a137-613436333131/2-108.jpg"
            alt="Corse"
          />
          <InfoContainer>
            <CorseName>Maize</CorseName>
            <CorsesUrl href="https://maize.by/">https://maize.by/</CorsesUrl>
            <CorseAdress>Ратомская 7</CorseAdress>
            <CorseDesc>
              Приготовить ужин под руководством харизматичного шеф-повара в
              уютной атмосфере - прекрасное решение для вашего личного
              праздника.
            </CorseDesc>
          </InfoContainer>
        </CorseCardContainer>
      </StyledCorsesList>
    </Container>
  );
};
