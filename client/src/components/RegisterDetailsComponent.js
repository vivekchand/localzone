import React, { Component } from "react";
import { Button, Form, FormGroup, Label, Input, Col } from "reactstrap";

class RegisterDetails extends Component {
  constructor(props) {
    super(props);

    this.state = {
      shopname: "",
      phoneno: "",
    };

    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleInputChange(event) {
    const target = event.target,
      value = target.value,
      name = target.name;

    this.setState({
      [name]: value,
    });
  }

  handleSubmit(event) {
    console.log("Current State is: " + JSON.stringify(this.state));
    alert("Current State is: " + JSON.stringify(this.state));
    event.preventDefault();
  }

  render() {
    return (
      <div className="container">
        <div className="row row-content">
          <div className="col-12 text-center">
            <h3>Congratulations ! Your Account is successfully created</h3>
            <span>
              Only few more steps to start with the Local Zone Experience
            </span>
          </div>
          <div className="col-12 col-md-9">
            <Form onSubmit={this.handleSubmit}>
            <FormGroup row>
            <Label htmlFor="payment" md={2}>Payment Preference</Label>
              <Col md={{size: 6, offset: 2}}>
                <FormGroup check>
                  <Label check>
                    <Input type="checkbox" name="cash" checked={this.state.cash}
                      onChange={this.handleInputChange} /> Pay By Cash
                  </Label>
                </FormGroup>
                <FormGroup check>
                  <Label check>
                    <Input type="checkbox" name="online" checked={this.state.online}
                      onChange={this.handleInputChange} /> Online Payment (UPI)
                  </Label>
                </FormGroup>
              </Col>
            </FormGroup>
            <FormGroup row>
            <Label htmlFor="payment" md={2}>Delivery Preference</Label>
              <Col md={{size: 6, offset: 2}}>
                <FormGroup check>
                  <Label check>
                    <Input type="checkbox" name="pickup" checked={this.state.pickup}
                      onChange={this.handleInputChange} /> Pickup at Store
                  </Label>
                </FormGroup>
                <FormGroup check>
                  <Label check>
                    <Input type="checkbox" name="homedelivery" checked={this.state.homedelivery}
                      onChange={this.handleInputChange} /> Home Delivery
                  </Label>
                </FormGroup>
              </Col>
            </FormGroup>
            <FormGroup row>
              <Col className="mt-30">
                  <Button type="submit" className="btn btn-block mx-auto d-block" color="primary">
                    Next
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

export default RegisterDetails;
