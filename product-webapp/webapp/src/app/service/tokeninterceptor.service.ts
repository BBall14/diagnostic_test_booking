import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SecurityService } from './security.service';

@Injectable({
  providedIn: 'root'
})
export class TokeninterceptorService implements HttpInterceptor {

  constructor(private securityService: SecurityService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let tokenHeader = req.clone({
      setHeaders: {
        Authorization: `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJQcmFkZWVwRGV2IiwiaWF0IjoxNjg3ODUyOTM3fQ.DXlJyzQvWlHvB0qtYlsP3kKs4vYuZ0OL9bzzQpRWwOk`
      }
    });

    return next.handle(tokenHeader);
  }
}
