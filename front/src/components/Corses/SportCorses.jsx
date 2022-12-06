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

export const SportCorses = () => {
  return (
    <Container>
      <ContainerResult>
        <TitleRez>Результат:</TitleRez>
        <DescRez>
          Посвятив себя активному образу жизни, вы сможете удовлетворить
          природную потребность в движении. Подходящие хобби – йога, боевые
          искусства, плавание, бильярд, теннис, танцы.
        </DescRez>
        <VarRez>Список различных хобби посвященных спорту:</VarRez>
      </ContainerResult>
      <StyledCorsesList>
        <CorseCardContainer>
          <Image
            src="https://thumb.tildacdn.com/tild6132-3034-4837-a563-666334336230/-/resize/720x/-/format/webp/2_41.jpg"
            alt="Corse"
          />
          <InfoContainer>
            <CorseName>StartVolley</CorseName>
            <CorsesUrl href="https://startvolley.by/">
              https://startvolley.by/
            </CorsesUrl>
            <CorseAdress>Космонавтов 56</CorseAdress>
            <CorseDesc>
              Первая школа в Беларуси по волейболу для взрослых и детей
            </CorseDesc>
          </InfoContainer>
        </CorseCardContainer>
      </StyledCorsesList>
    </Container>
  );
};
