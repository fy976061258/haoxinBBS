import axios from 'axios';

let base = 'video';

export const getVideo = params => { return axios.post(`${base}/login`, params).then(res => res.data); };
