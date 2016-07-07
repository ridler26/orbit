var container;
var camera, scene, renderer;
var earth;
var mouseX = 0, mouseY = 0;
var boost = 1; //ускорение
var windowHalfX = window.innerWidth / 2;
var windowHalfY = window.innerHeight / 2;
init();
animate();
function init() {

    container = document.getElementById( 'scene' );
    camera = new THREE.PerspectiveCamera( 60, window.innerWidth / window.innerHeight, 1, 2000 );
    camera.position.z = 500;
    scene = new THREE.Scene();
    earth = new THREE.Group();
    scene.add( earth );
    // earth
    var loader = new THREE.TextureLoader();
    //FIXME
    var imgurl = "../../static/img/land_ocean_ice_cloud_2048.jpg";
    loader.load(imgurl, function (texture) {
                    var geometry = new THREE.SphereGeometry( 200, 30, 30 );
                    var material = new THREE.MeshBasicMaterial({ map: texture, overdraw: 0.5 });
                    var mesh = new THREE.Mesh(geometry, material);
                    earth.add(mesh);
    } );

    var canvas = document.createElement( 'canvas' );
    canvas.width = 128;
    canvas.height = 128;
    var context = canvas.getContext( '2d' );
    var gradient = context.createRadialGradient(
                    canvas.width / 2,
                    canvas.height / 2,
                    0,
                    canvas.width / 2,
                    canvas.height / 2,
                    canvas.width / 2
    );
    gradient.addColorStop( 0.1, 'rgba(210,210,210,1)' );
    gradient.addColorStop( 1, 'rgba(255,255,255,1)' );
    context.fillStyle = gradient;
    context.fillRect( 0, 0, canvas.width, canvas.height );

    renderer = new THREE.CanvasRenderer();
    renderer.setClearColor(0x000000, 1);
    renderer.setPixelRatio( window.devicePixelRatio );
    renderer.setSize( window.innerWidth, window.innerHeight - 70);
    container.appendChild( renderer.domElement );
    document.addEventListener( 'mousemove', onDocumentMouseMove, false );
    document.body.addEventListener( 'mousewheel', mousewheel, false );
    document.body.addEventListener( 'DOMMouseScroll', mousewheel, false ); // firefox

    window.addEventListener( 'resize', onWindowResize, false );
}

function onWindowResize() {
    windowHalfX = window.innerWidth / 2;
    windowHalfY = window.innerHeight / 2;
    camera.aspect = window.innerWidth / window.innerHeight;
    camera.updateProjectionMatrix();
    renderer.setSize( window.innerWidth, window.innerHeight );
}
function onDocumentMouseMove( event ) {
    //TODO движение камеры только при нажатии левой кнопки например
   //mouseX = ( event.clientX - windowHalfX );
   //mouseY = ( event.clientY - windowHalfY );
}

function mousewheel( e ) {      
    var d = ((typeof e.wheelDelta != "undefined")?(-e.wheelDelta):e.detail);
    d = 100 * ((d>0)?1:-1);

    var cPos = camera.position;
    if (isNaN(cPos.x) || isNaN(cPos.y) || isNaN(cPos.y))
      return;

    var r = cPos.x * cPos.x + cPos.y * cPos.y;
    var sqr = Math.sqrt(r);
    var sqrZ = Math.sqrt(cPos.z * cPos.z + r);


    var nx = cPos.x + ((r==0)?0:(d * cPos.x/sqr));
    var ny = cPos.y + ((r==0)?0:(d * cPos.y/sqr));
    var nz = cPos.z + ((sqrZ==0)?0:(d * cPos.z/sqrZ));

    if (nx > 2000 || ny > 2000 || nz > 2000)
        return;

    if (Math.sqrt(nx*nx + ny*ny + nz*nz) < 300)
        return; 

    if (isNaN(nx) || isNaN(ny) || isNaN(nz))
      return;

    cPos.x = nx;
    cPos.y = ny;
    cPos.z = nz;
}

function animate() {
    requestAnimationFrame(animate);
    render();
}
function render() {
    camera.lookAt(earth.position);

    updateShipOrbit();
    updateEarthRotation();
    updateEarthSolRotation();
    renderer.render(scene, camera);
}

function updateShipOrbit() {
    
}

function updateEarthRotation() {
    //earth.rotation.y -= y * boost;
    //earth.rotation.x -= x * boost;
    //earth.rotation.z -= z * boost;
}

function updateEarthSolRotation() {
    //earth.x -= x * boost;
    //earth.y -= y * boost;
    //earth.z -= z * boost;
}