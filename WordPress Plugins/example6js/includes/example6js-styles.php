<?php

function example6css_admin_styles() {
  wp_enqueue_style(
    'example56css-admin',
    WPPLUGIN_URL . 'admin/styles.css',
    [],
    time()
  );


}

add_action('admin_enqueue_scripts', 'example6css_admin_styles');



//Front end
function example6css_frontend_styles() {

  wp_enqueue_style(
    'example6css-frontend',
    WPPLUGIN_URL . 'frontend/styles.css',
    [],
    time()
  );


}

add_action('wp_enqueue_scripts', 'example6css_frontend_styles', 100);
