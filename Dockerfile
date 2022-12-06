FROM nginx:latest
EXPOSE 80
COPY ./devops/default.conf /etc/nginx/conf.d/default.conf
COPY ./front/build /usr/share/nginx/html
