// landing-N7 [ptm4anov0s]
/* ========== */
/*!
 * MoveTo - A lightweight scroll animation javascript library without any dependency.
 * Version 1.8.2 (28-06-2019 14:30)
 * Licensed under MIT
 * Copyright 2019 Hasan Aydoğdu <hsnaydd@gmail.com>
 */
"use strict";
var MoveTo = function() {
  var e = {
    tolerance: 0,
    duration: 800,
    easing: "easeOutQuart",
    container: window,
    callback: function() {}
  };

  function o(t, n, e, o) {
    return t /= o, -e * (--t * t * t * t - 1) + n
  }

  function v(n, e) {
    var o = {};
    return Object.keys(n).forEach(function(t) {
      o[t] = n[t]
    }), Object.keys(e).forEach(function(t) {
      o[t] = e[t]
    }), o
  }

  function d(t) {
    return t instanceof HTMLElement ? t.scrollTop : t.pageYOffset
  }

  function t() {
    var t = 0 < arguments.length && void 0 !== arguments[0] ? arguments[0] : {},
      n = 1 < arguments.length && void 0 !== arguments[1] ? arguments[1] : {};
    this.options = v(e, t), this.easeFunctions = v({
      easeOutQuart: o
    }, n)
  }
  return t.prototype.registerTrigger = function(t, n) {
    var e = this;
    if (t) {
      var o = t.getAttribute("href") || t.getAttribute("data-target"),
        r = o && "#" !== o ? document.getElementById(o.substring(1)) : document.body,
        i = v(this.options, function(e, t) {
          var o = {};
          return Object.keys(t).forEach(function(t) {
            var n = e.getAttribute("data-mt-".concat(function(t) {
              return t.replace(/([A-Z])/g, function(t) {
                return "-" + t.toLowerCase()
              })
            }(t)));
            n && (o[t] = isNaN(n) ? n : parseInt(n, 10))
          }), o
        }(t, this.options));
      "function" == typeof n && (i.callback = n);
      var a = function(t) {
        t.preventDefault(), e.move(r, i)
      };
      return t.addEventListener("click", a, !1),
        function() {
          return t.removeEventListener("click", a, !1)
        }
    }
  }, t.prototype.move = function(i) {
    var a = this,
      c = 1 < arguments.length && void 0 !== arguments[1] ? arguments[1] : {};
    if (0 === i || i) {
      c = v(this.options, c);
      var u, s = "number" == typeof i ? i : i.getBoundingClientRect().top,
        f = d(c.container),
        l = null;
      s -= c.tolerance;
      window.requestAnimationFrame(function t(n) {
        var e = d(a.options.container);
        l || (l = n - 1);
        var o = n - l;
        if (u && (0 < s && e < u || s < 0 && u < e)) return c.callback(i);
        u = e;
        var r = a.easeFunctions[c.easing](o, f, s, c.duration);
        c.container.scroll(0, r), o < c.duration ? window.requestAnimationFrame(t) : (c.container.scroll(0, s + f), c.callback(i))
      })
    }
  }, t.prototype.addEaseFunction = function(t, n) {
    this.easeFunctions[t] = n
  }, t
}();
"undefined" != typeof module ? module.exports = MoveTo : window.MoveTo = MoveTo;
(function() {
  // mail form
  const N7MailChimpForm = function() {
    const mcForm = document.querySelector('#mc-form');
    if (!mcForm) return;
    mcForm.setAttribute('novalidate', true);
    // Field validation
    function hasError(field) {
      if (field.disabled || field.type === 'file' || field.type === 'reset' || field.type === 'submit' || field.type === 'button') return;
      let validity = field.validity;
      if (validity.valid) return;
      if (validity.valueMissing) return 'Please enter an email address.';
      if (validity.typeMismatch) {
        if (field.type === 'email') return 'Please enter a valid email address.';
      }
      // If pattern doesn't match
      if (validity.patternMismatch) {
        if (field.hasAttribute('title')) return field.getAttribute('title');
        return 'Please match the requested format.';
      }
      return 'The value you entered for this field is invalid.';
    };
    // Show error message
    function showError(field, error) {
      let id = field.id || field.name;
      if (!id) return;
      let errorMessage = field.form.querySelector('.mc-status');
      errorMessage.classList.remove('success-message');
      errorMessage.classList.add('error-message');
      errorMessage.innerHTML = error;
    };
    // Check email field on submit
    mcForm.addEventListener('submit', function(event) {
      event.preventDefault();
      let emailField = event.target.querySelector('#mce-EMAIL');
      let error = hasError(emailField);
      if (error) {
        showError(emailField, error);
        emailField.focus();
        return;
      }
    }, false);
  };
  // back to top
  const N7BackToTop = function() {
    const pxShow = 900;
    const goTopButton = document.querySelector(".landing-N7 .ss-go-top");
    if (!goTopButton) return;
    // Show or hide the button
    if (window.scrollY >= pxShow) goTopButton.classList.add("link-is-visible");
    window.addEventListener("scroll", function() {
      if (window.scrollY >= pxShow) {
        if (!goTopButton.classList.contains("link-is-visible")) goTopButton.classList.add("link-is-visible");
      } else {
        goTopButton.classList.remove("link-is-visible");
      }
    });
    goTopButton.addEventListener('click', function() {
      window.scrollTo({
        top: 0,
        behavior: 'smooth'
      });
    });
  };
  /* Initialize */
  (function ssInitN7() {
    N7MailChimpForm();
    N7BackToTop();
  })();
})();
// landing-N6 [IPM4aNnHIc]
/* ========== */
/*!
 * MoveTo - A lightweight scroll animation javascript library without any dependency.
 * Version 1.8.2 (28-06-2019 14:30)
 * Licensed under MIT
 * Copyright 2019 Hasan Aydoğdu <hsnaydd@gmail.com>
 */
"use strict";
var MoveTo = function() {
  var e = {
    tolerance: 0,
    duration: 800,
    easing: "easeOutQuart",
    container: window,
    callback: function() {}
  };

  function o(t, n, e, o) {
    return t /= o, -e * (--t * t * t * t - 1) + n
  }

  function v(n, e) {
    var o = {};
    return Object.keys(n).forEach(function(t) {
      o[t] = n[t]
    }), Object.keys(e).forEach(function(t) {
      o[t] = e[t]
    }), o
  }

  function d(t) {
    return t instanceof HTMLElement ? t.scrollTop : t.pageYOffset
  }

  function t() {
    var t = 0 < arguments.length && void 0 !== arguments[0] ? arguments[0] : {},
      n = 1 < arguments.length && void 0 !== arguments[1] ? arguments[1] : {};
    this.options = v(e, t), this.easeFunctions = v({
      easeOutQuart: o
    }, n)
  }
  return t.prototype.registerTrigger = function(t, n) {
    var e = this;
    if (t) {
      var o = t.getAttribute("href") || t.getAttribute("data-target"),
        r = o && "#" !== o ? document.getElementById(o.substring(1)) : document.body,
        i = v(this.options, function(e, t) {
          var o = {};
          return Object.keys(t).forEach(function(t) {
            var n = e.getAttribute("data-mt-".concat(function(t) {
              return t.replace(/([A-Z])/g, function(t) {
                return "-" + t.toLowerCase()
              })
            }(t)));
            n && (o[t] = isNaN(n) ? n : parseInt(n, 10))
          }), o
        }(t, this.options));
      "function" == typeof n && (i.callback = n);
      var a = function(t) {
        t.preventDefault(), e.move(r, i)
      };
      return t.addEventListener("click", a, !1),
        function() {
          return t.removeEventListener("click", a, !1)
        }
    }
  }, t.prototype.move = function(i) {
    var a = this,
      c = 1 < arguments.length && void 0 !== arguments[1] ? arguments[1] : {};
    if (0 === i || i) {
      c = v(this.options, c);
      var u, s = "number" == typeof i ? i : i.getBoundingClientRect().top,
        f = d(c.container),
        l = null;
      s -= c.tolerance;
      window.requestAnimationFrame(function t(n) {
        var e = d(a.options.container);
        l || (l = n - 1);
        var o = n - l;
        if (u && (0 < s && e < u || s < 0 && u < e)) return c.callback(i);
        u = e;
        var r = a.easeFunctions[c.easing](o, f, s, c.duration);
        c.container.scroll(0, r), o < c.duration ? window.requestAnimationFrame(t) : (c.container.scroll(0, s + f), c.callback(i))
      })
    }
  }, t.prototype.addEaseFunction = function(t, n) {
    this.easeFunctions[t] = n
  }, t
}();
"undefined" != typeof module ? module.exports = MoveTo : window.MoveTo = MoveTo;
(function(html) {
  // move header
  const N6MoveHeader = function() {
    const hdr = document.querySelector('.landing-N6 .s-header');
    const hero = document.querySelector('#intro');
    let triggerHeight;
    if (!(hdr && hero)) return;
    setTimeout(function() {
      triggerHeight = hero.offsetHeight - 170;
    }, 300);
    window.addEventListener('scroll', function() {
      let loc = window.scrollY;
      if (loc > triggerHeight) {
        hdr.classList.add('sticky');
      } else {
        hdr.classList.remove('sticky');
      }
      if (loc > triggerHeight + 20) {
        hdr.classList.add('offset');
      } else {
        hdr.classList.remove('offset');
      }
      if (loc > triggerHeight + 150) {
        hdr.classList.add('scrolling');
      } else {
        hdr.classList.remove('scrolling');
      }
    });
  };
  // mobile menu
  const N6MobileMenu = function() {
    const toggleButton = document.querySelector('.landing-N6 .s-header__menu-toggle');
    const mainNavWrap = document.querySelector('.landing-N6 .s-header__nav');
    const siteBody = document.querySelector('body');
    if (!(toggleButton && mainNavWrap)) return;
    toggleButton.addEventListener('click', function(event) {
      event.preventDefault();
      toggleButton.classList.toggle('is-clicked');
      siteBody.classList.toggle('menu-is-open');
    });
    mainNavWrap.querySelectorAll('.landing-N6 .s-header__nav a').forEach(function(link) {
      link.addEventListener("click", function(event) {
        // at 800px and below
        if (window.matchMedia('(max-width: 800px)').matches) {
          toggleButton.classList.toggle('is-clicked');
          siteBody.classList.toggle('menu-is-open');
        }
      });
    });
    window.addEventListener('resize', function() {
      // above 800px
      if (window.matchMedia('(min-width: 801px)').matches) {
        if (siteBody.classList.contains('menu-is-open')) siteBody.classList.remove('menu-is-open');
        if (toggleButton.classList.contains('is-clicked')) toggleButton.classList.remove('is-clicked');
      }
    });
  };
  // smoothscroll
  const N6ssMoveTo = function() {
    const easeFunctions = {
      easeInQuad: function(t, b, c, d) {
        t /= d;
        return c * t * t + b;
      },
      easeOutQuad: function(t, b, c, d) {
        t /= d;
        return -c * t * (t - 2) + b;
      },
      easeInOutQuad: function(t, b, c, d) {
        t /= d / 2;
        if (t < 1) return (c / 2) * t * t + b;
        t--;
        return (-c / 2) * (t * (t - 2) - 1) + b;
      },
      easeInOutCubic: function(t, b, c, d) {
        t /= d / 2;
        if (t < 1) return (c / 2) * t * t * t + b;
        t -= 2;
        return (c / 2) * (t * t * t + 2) + b;
      },
    };
    const triggers = document.querySelectorAll(".smoothscroll");
    const moveTo = new MoveTo({
      tolerance: 0,
      duration: 1200,
      easing: "easeInOutCubic",
      container: window,
    }, easeFunctions);
    triggers.forEach(function(trigger) {
      moveTo.registerTrigger(trigger);
    });
  };
  /* Initialize */
  (function ssInitN6() {
    N6MoveHeader();
    N6MobileMenu();
    N6ssMoveTo();
  })();
})(document.documentElement);