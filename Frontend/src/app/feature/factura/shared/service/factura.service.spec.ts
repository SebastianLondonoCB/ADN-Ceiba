import { TestBed } from '@angular/core/testing';

import { FacturaService } from './factura.service';
import { HttpClientModule } from '@angular/common/http';

describe('FacturaService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientModule
    ],
  }));

  it('should be created', () => {
    const service: FacturaService = TestBed.get(FacturaService);
    expect(service).toBeTruthy();
  });
});
