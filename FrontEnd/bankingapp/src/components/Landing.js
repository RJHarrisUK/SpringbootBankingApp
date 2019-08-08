import React, { Component } from "react";
import axios from "axios";
import { BrowserRouter as Router, Route } from "react-router-dom";

import Navigationbar from './Navigationbar.js';
import RegisterCustomer from './RegisterCustomer.js';

export default class Landing extends Component {

    constructor() {
        super();
        this.state = {
            data: []
        }
    }

    componentDidMount() {
        this.getAll();
    }

    getAll = () => {
        axios
            .get('http://localhost:5000/User/all')
            .then(response => {

                this.setState({
                    data: response.data
                })
                console.log(response.data);
            })
    }

    render() {
        return (
            <div>
                <Router>
                    <Navigationbar />
                    <Route exact path="/" render={() => <RegisterCustomer onload={this.onLoad} />} />
                </Router>
            </div>
        )
    }

}