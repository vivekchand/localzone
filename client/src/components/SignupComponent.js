import React, { Component } from 'react';
import { Button, Form, FormGroup, Label, Input, Col } from 'reactstrap';

class Signup extends Component {
  constructor(props) {
    super(props);

    this.state = {
        shopname: '',
        phoneno: '',
    };

    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleInputChange(event) {
    const target = event.target,
          value = target.value,
          name = target.name;

    this.setState({
      [name]: value
    });
  }

  handleSubmit(event) {
    console.log('Current State is: ' + JSON.stringify(this.state));
    alert('Current State is: ' + JSON.stringify(this.state));
    event.preventDefault();
  } 
  
  render() {
    return (
      <div className="container">
        <div className="row row-content">
          <div className="col-12 text-center">
            <h3>Local Zone</h3>
            <span>Easy to Sell & Shop local products during COVID-19 Lockdown</span>
          </div>
          <div className="col-12 col-md-9">
            <Form onSubmit={this.handleSubmit}>
              <FormGroup row>
                <Label htmlFor="shopname" md={2}> Shop Name </Label>
                <Col md={10}>
                  <Input type="text" id="shopname" name="shopname" placeholder="Enter your Shop Name"
                    value={this.state.shopname} onChange={this.handleInputChange}
                  />
                </Col>
              </FormGroup>
              <FormGroup row>
                <Label htmlFor="phoneno" md={2}>Phone Number</Label>
                <Col md={10}>
                  <Input
                    type="tel" id="phoneno" name="phoneno" placeholder="Enter your Phone Number"
                    value={this.state.telnum} onChange={this.handleInputChange}
                  />
                </Col>
              </FormGroup>
              <FormGroup row>
              <span>Note : OTP will be sent to the above number for created account </span>
                <Col className="mt-30">
                  <Button type="submit" className="btn btn-block mx-auto d-block" color="primary">
                    Get Started
                  </Button>
                </Col>
              </FormGroup>
            </Form>
          </div>
        </div>
      </div>
    );
  }
}

export default Signup;
