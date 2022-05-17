import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Track } from './track.model';
import { NumberSymbol } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class MusicApiService {

  readonly baseApiUrl = "http://localhost:8080/music";

  subjectNotifier : Subject<null> = new Subject<null>();

  constructor(private http: HttpClient) { }

  //Get Tracks
  getAllMusic() : Observable<Track[]> {
    return this.http.get<Track[]>(this.baseApiUrl + "/tracks");
  }

  //Get Track by Id
  getMusicById(id : number) : Observable<Track>{
    return this.http.get<Track>(this.baseApiUrl + `/track/${id}`);
  }

  //Create Track
  postMusic(data: Track) {
    return this.http.post(this.baseApiUrl + "/track", data);
  }

  //Update Track
  putMusic(id : number, data : Track) {
    return this.http.put(this.baseApiUrl + `/track/${id}`, data);
  }

  //Delete Track
  deleteMusic(data : number) {
    return this.http.delete<Track[]>(this.baseApiUrl + `/track/${data}`);
  }

  notifyChange() {
    this.subjectNotifier.next(null);
  }

}
