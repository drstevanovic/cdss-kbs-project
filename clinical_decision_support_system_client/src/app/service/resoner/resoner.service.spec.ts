import { TestBed, inject } from '@angular/core/testing';

import { ResonerService } from './resoner.service';

describe('ResonerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ResonerService]
    });
  });

  it('should be created', inject([ResonerService], (service: ResonerService) => {
    expect(service).toBeTruthy();
  }));
});
