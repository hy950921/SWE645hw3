FROM node:12.16.2-alpine3.9 AS build-step
WORKDIR /app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.16.1-alpine AS prod-stage
COPY --from=build-step /app/dist/angular8-frontend /usr/share/nginx/html
