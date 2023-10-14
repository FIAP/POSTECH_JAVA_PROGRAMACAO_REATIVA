import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  vus: 300,
  duration: '30s',
};

export default function () {
  http.get('http://localhost:8080/produto/2');
  sleep(1);
}