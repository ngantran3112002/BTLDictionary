import { Express } from 'express'
import configViewEngine from './viewEngine/viewEngine';
import initwebroute from './route/web'
import connectdb from './config/connectDB'
const express = require('express')
const bodyParser = require('body-parser')

const app = express();
require('dotenv').config();
app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.json());
const port = process.env.PORT;



configViewEngine(app);
initwebroute(app);

connectdb(app);



app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})