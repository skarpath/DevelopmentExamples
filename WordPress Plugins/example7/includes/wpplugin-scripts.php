<?php

function wpplugin_admin_scripts( $hook ) {

  wp_register_script(
    'wpplugin_admin',
    WPPLUGIN_URL . 'admin/scripts.js',
    ['jquery'],
    time()
  );

  //Localize script send custom varibles to frontend
  wp_localize_script('wpplugin-admin','wpplugin', [
    'hook' => $hook
    ]);

  if('toplevel_page_wpplugin' == $hook){
    wp_enqueue_script('wpplugin_admin');
  }

}

add_action('admin_enqueue_scripts', 'wpplugin_admin_scripts');



//Front end
function wpplugin_frontend_scripts() {

  wp_register_script(
    'wpplugin-frontend',
    WPPLUGIN_URL . 'frontend/scripts.js',
    [],
    time()
  );

  if(is_single()){
    wp_enqueue_script('wpplugin-frontend');
  }}

add_action('wp_enqueue_scripts', 'wpplugin_frontend_scripts');
