<?php

function example5css_admin_styles() {
  wp_enqueue_style(
    'example5css-admin',
    WPPLUGIN_URL . 'admin/styles.css',
    [],
    time()
  );


}

add_action('admin_enqueue_scripts', 'example5css_admin_styles');



//Front end
function example5css_frontend_styles() {

  wp_enqueue_style(
    'example5css-frontend',
    WPPLUGIN_URL . 'frontend/styles.css',
    [],
    time()
  );


}

add_action('wp_enqueue_scripts', 'example5css_frontend_styles', 100);
