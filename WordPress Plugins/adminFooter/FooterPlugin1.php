<?php
/*
Plugin Name:  Replace admin footer text
Plugin URI:   https://developer.wordpress.org/plugins/the-basics/
Description:  Will replace admin footer text
Version:      0.1
Author:       Stephen K
Author URI:   stephenkarpath.com
License:      GPL2
License URI:  https://www.gnu.org/licenses/gpl-2.0.html
Text Domain:  wporg
Domain Path:  /languages
*/

//If the following plugin is already defined, then quit
if ( ! defined ( 'WPINC')){
  die;
}

include( plugin_dir_path( __FILE__) . 'includes/footer1.php' );

?>
