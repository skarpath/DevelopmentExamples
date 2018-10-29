<?php

function wpplugin_admin_styles( $hook ) {


  //Register Stle
  wp_register_style(
    'mycp1_admin',
    WPPLUGIN_URL . 'admin/styles.css',
    [],
    time()
  );

  if ('toplevel_page_wpplugin' == $hook){
    wp_enqueue_style( 'wpplugin-admin' );
  }
}

add_action('admin_enqueue_scripts', 'wpplugin_admin_styles');



//Front end
function wpplugin__frontend_styles() {

  //Register style
  wp_register_style(
    'wpplugin-frontend',
    WPPLUGIN_URL . 'frontend/styles.css',
    [],
    time()
  );

  if ( is_single() ){
    wp_enqueue_style('wpplugin-frontend');
  }


}

add_action('wp_enqueue_scripts', 'wpplugin__frontend_styles', 100);
