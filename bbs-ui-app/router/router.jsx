import index from "../src/index/App";
import video from "../src/video/video";


var indexRoutes = [
    { path: "/index", name: "index", component: index },
    { path: "/video", name: "video", component: video },
];

export default indexRoutes;
