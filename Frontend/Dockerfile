FROM node:alpine as builder
WORKDIR '/app'
COPY package*.json ./
RUN npm ci
COPY . .
RUN npx ng build --prod pizza
FROM nginx
EXPOSE 80
COPY --from=builder /app/dist/pizza /usr/share/nginx/html
