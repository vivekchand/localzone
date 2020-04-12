import React, { Component } from 'react';
import Signup from './SignupComponent';
import ValidateOtp from './ValidateOtpComponent';
import RegisterDetails from './RegisterDetailsComponent'
import Category from './CategoryComponent'
import AddProduct from './AddProductComponent'


class Main extends Component {
  render() {
    return (
        <div>
          <Signup />
          <ValidateOtp />
          <RegisterDetails />
          <Category />
          <AddProduct />
        </div>
    );
  }
}

export default Main;