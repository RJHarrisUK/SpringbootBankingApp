import React, { Component } from 'react';
import axios from 'axios';

export default class RegisterCustomer extends Component {

    constructor() {
        super();
        this.state = {
            data: [],
            accountNumber: "",
            prizeResponse: "",
        };
    }

    createCustomer = (event) => {

        event.preventDefault();

        let newCustomer = {
            firstName: event.target[0].value,
            lastName: event.target[1].value,
        }

        axios
            .post("http://localhost:8080/createAccount", newCustomer)
            .then(response => {

                this.setState({ "accountNumber": "Your account number is: " + JSON.stringify(response.data.accountNumber) })
                this.setState({ "prizeResponse": JSON.stringify(response.data.prize) })

                console.log(response.data.accountNumber)
                console.log(response.data.prize)

            }).catch(err => console.log(err))
    }

    render() {

        return (
            <div>
                <h1>Register Customer</h1>
                <form onSubmit={this.createCustomer}>
                    <input id="firstname" type="text" placeholder="First Name"></input>
                    <br></br>
                    <input id="lastname" type="text" placeholder="Last Name"></input>
                    <br></br>
                    <p style={{ color: 'blue' }}>{this.state.accountNumber}</p>
                    <p style={{ color: 'blue' }}>{this.state.prizeResponse}</p>
                    <br></br>
                    <button type="submit" >Register Customer</button>
                </form>
            </div>
        )
    }

}