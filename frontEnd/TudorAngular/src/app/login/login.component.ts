import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginRequest } from '../login-request';
import { LoginResponse } from '../login-response';
import { LoginService } from '../login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginRequest: LoginRequest;
  loginResponse: LoginResponse;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private loginService: LoginService) {
    this.loginRequest = new LoginRequest();
    this.loginResponse = new LoginResponse();
  }

  onLogin() {
    console.log(this.loginRequest)
    this.loginService.requestLogin(this.loginRequest)
      .subscribe(data => {
        this.loginResponse = data;
        console.log(this.loginResponse)
        if (this.loginResponse.isAdmin) {
          this.goToAdminScreen()
        } else {
          this.goToUserScreen()
        }

      })
  }


  goToAdminScreen() {
    this.router.navigate(['/admin']);
  }
  goToUserScreen() {
    this.router.navigate(['/user']);
  }

}
