//修改视频播放速度
function onchangePlaybackRate($this) {
    $this = $($this);
    //倍数
    let rateVal = $this.val();
    //视频元素
    let $video = $this.closest('li').find(".video");
    let video = $video[0];
    video.playbackRate = rateVal;
    video.play();
}
