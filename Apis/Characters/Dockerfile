FROM node:10.12.0-alpine

COPY . /src
WORKDIR /src

RUN npm install
RUN npm test
CMD ["npm", "start"]
