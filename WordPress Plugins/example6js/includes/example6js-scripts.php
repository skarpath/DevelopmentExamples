<?php

function example6js_admin_scripts() {
  wp_enqueue_script(
    'example6js-admin',
    WPPLUGIN_URL . 'admin/scripts.js',
    ['jquery'],
    time()
  );


}

add_action('admin_enqueue_scripts', 'example6js_admin_scripts', 100);



//Front end
function example6js_frontend_scripts() {

  wp_enqueue_script(
    'example6js-frontend',
    WPPLUGIN_URL . 'frontend/frontend.js',
    [],
    time()
  );


}

add_action('wp_enqueue_scripts', 'example6js_frontend_scripts', 100);
