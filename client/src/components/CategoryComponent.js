import React, { Component } from 'react';
import { Button, Form, FormGroup, Label, Input, Col } from 'reactstrap';
import {CATEGORIES} from '../shared/category';

class Category extends Component {
  constructor(props) {
    super(props);

    this.state = {
        otp: '',
        categories : CATEGORIES
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
    console.log(this.state);
    const category = (this.state.categories).map((category) => {
      return(
        <FormGroup check key={category.id}>
                  <Label check>
                    <Input type="checkbox" name={category.name} checked={category.id}
                      onChange={this.handleInputChange} /> {category.name}
                  </Label>
        </FormGroup>
    );
    });
    return (
      <div className="container">
        <div className="row row-content">
          <div className="col-12 text-center">
            <h3>What to you Sell ?</h3>
            <span>
              Please choose the Category of products that you sell
            </span>
          </div>
          <div className="col-12 col-md-9">
            <Form onSubmit={this.handleSubmit}>
            <FormGroup row>
            <Label htmlFor="category" md={2}>Product Category</Label>
              <Col md={{size: 6, offset: 2}}>
                {category}
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

export default Category;
