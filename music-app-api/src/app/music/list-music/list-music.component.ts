import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { Track } from '../../track.model';
import { MusicApiService } from '../../music-api.service';

@Component({
  selector: 'app-list-music',
  templateUrl: './list-music.component.html',
  styleUrls: ['./list-music.component.css']
})
export class ListMusicComponent implements OnInit {

  musicList$ ! : Observable<Track[]>;

  track = new Track()

  notifyChange : Subscription = this.service.subjectNotifier.subscribe(notify => {
    this.musicList$ = this.service.getAllMusic();
  });

  constructor(private service: MusicApiService) { }

  ngOnInit(): void {
    this.musicList$ = this.service.getAllMusic();
  }

  ngOnDestroy() : void {
    this.notifyChange.unsubscribe();
  }

  deleteMusic(music : Track) {
    //Access to Music Object
    if (confirm(`Are you sure you want to delete music id ${music.id}?`)) {
      //Sending delete request to service
      this.service.deleteMusic(music.id).subscribe(res => {
        this.service.notifyChange();
      });
    }
  }

  editMusic(musicId : number) {
    this.service.getMusicById(musicId).subscribe(response => {
      this.track = response;
    });
  }


  updateMusic() {
    this.service.putMusic(this.track.id, this.track).subscribe(res => {
      this.service.notifyChange();
      const editMusicModalCloseBtn = document.getElementById("editMusicModalClose");
      if (editMusicModalCloseBtn) {
        editMusicModalCloseBtn.click();
      }
    });
  }
}
