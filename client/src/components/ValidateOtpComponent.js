import React, { Component } from 'react';
import { Button, Form, FormGroup, Label, Input, Col } from 'reactstrap';

class ValidateOtp extends Component {
  constructor(props) {
    super(props);

    this.state = {
        otp: '',
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
            <h3>Validate OTP</h3>
          </div>
          <div className="col-12 col-md-9">
            <Form onSubmit={this.handleSubmit}>
              <FormGroup row>
                <Label htmlFor="otp" md={2}> OTP</Label>
                <Col md={10}>
                  <Input type="text" id="otp" name="otp" placeholder="Enter OTP"
                    value={this.state.otp} onChange={this.handleInputChange}
                  />
                </Col>
              </FormGroup>

              <FormGroup row>
                <Col className="mt-30">
                  <Button type="submit" className="btn btn-block mx-auto d-block" color="primary">
                    Create Account
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

export default ValidateOtp;
