import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from './login-request';
import { User } from './user';
import { Observable } from 'rxjs';
import { LoginResponse } from './login-response';

@Injectable()
export class LoginService {

  private userUrl: string;
  private loginResp: LoginResponse;

  constructor(private http: HttpClient) {
    this.userUrl = 'http://localhost:8080/login';
    this.loginResp = new LoginResponse();
  }

  public requestLogin(loginReq: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(this.userUrl, loginReq);
  }


}


