webpackHotUpdate_N_E("pages/index",{

/***/ "./src/components/layout/Header.js":
/*!*****************************************!*\
  !*** ./src/components/layout/Header.js ***!
  \*****************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony import */ var J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/defineProperty */ "./node_modules/@babel/runtime/helpers/esm/defineProperty.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! react/jsx-dev-runtime */ "./node_modules/react/jsx-dev-runtime.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @chakra-ui/react */ "./node_modules/@chakra-ui/react/dist/esm/index.js");
/* harmony import */ var components_layout_Container__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! components/layout/Container */ "./src/components/layout/Container.js");
/* harmony import */ var react_icons_fa__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! react-icons/fa */ "./node_modules/react-icons/fa/index.esm.js");
/* harmony import */ var react_icons_md__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! react-icons/md */ "./node_modules/react-icons/md/index.esm.js");
/* harmony import */ var components_layout_ThemeSwitch__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! components/layout/ThemeSwitch */ "./src/components/layout/ThemeSwitch.js");
/* harmony import */ var components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! components/AuthProvider */ "./src/components/AuthProvider.js");



var _jsxFileName = "J:\\Java\\Spring\\hub\\hub-frontend\\src\\components\\layout\\Header.js",
    _this = undefined,
    _s = $RefreshSig$(),
    _s2 = $RefreshSig$(),
    _s3 = $RefreshSig$();

function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { Object(J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_0__["default"])(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }








var Header = function Header(props) {
  _s();

  var bgColor = Object(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"])('gray.50', 'gray.900');
  var color = Object(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"])('black', 'white');
  console.log('header');
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_Container__WEBPACK_IMPORTED_MODULE_3__["Container"], _objectSpread(_objectSpread({
    zIndex: "1",
    height: {
      sm: '4.5rem',
      base: 'auto'
    },
    bg: bgColor,
    color: color,
    shadow: "sm",
    paddingX: "37px"
  }, props), {}, {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_Container__WEBPACK_IMPORTED_MODULE_3__["Content"], {
      flexDirection: {
        sm: 'row',
        base: 'column'
      },
      justifyContent: "space-between",
      alignItems: "center",
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Box"], {
        width: {
          sm: '100px',
          base: 'auto'
        },
        paddingY: {
          sm: '0px',
          base: '7px'
        },
        children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], {
          href: "/",
          _focus: {
            outline: 0
          },
          children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Heading"], {
            fontSize: "1.5rem",
            paddingRight: "0px",
            children: "Hub"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 50,
            columnNumber: 13
          }, _this)
        }, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 49,
          columnNumber: 11
        }, _this)
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 45,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Navigation, {
        paddingY: {
          sm: '0px',
          base: '7px'
        }
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 55,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Profile, {
        paddingY: {
          sm: '0px',
          base: '7px'
        }
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 56,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 40,
      columnNumber: 7
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 31,
    columnNumber: 5
  }, _this);
};

_s(Header, "GxINmYQjSw+rm7TrtZAlo2dz7DQ=", false, function () {
  return [_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"], _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"]];
});

_c = Header;

var Navigation = function Navigation(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], _objectSpread(_objectSpread({}, props), {}, {
    children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "About",
      href: "/about"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 65,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Docs",
      href: "/docs"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 66,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Explore",
      href: "/explore"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 67,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Support",
      href: "https://panda-lang.org/support/"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 68,
      columnNumber: 7
    }, _this)]
  }), void 0, true, {
    fileName: _jsxFileName,
    lineNumber: 64,
    columnNumber: 5
  }, _this);
};

_c2 = Navigation;

var NavigationItem = function NavigationItem(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], _objectSpread(_objectSpread({
    href: props.href,
    fontWeight: "bold",
    paddingX: "13px",
    _focus: {
      outline: 0
    }
  }, props), {}, {
    children: props.label
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 75,
    columnNumber: 5
  }, _this);
};

_c3 = NavigationItem;

var Profile = function Profile(props) {
  _s2();

  var _useAuth = Object(components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"])(),
      token = _useAuth.token;

  var view = token ? /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(ProfileMenu, {}, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 90,
    columnNumber: 24
  }, _this) : /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Login, {}, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 90,
    columnNumber: 41
  }, _this);
  console.log('profile');
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], _objectSpread(_objectSpread({
    alignItems: "center",
    display: {
      sm: 'flex',
      base: 'none'
    }
  }, props), {}, {
    children: view
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 93,
    columnNumber: 5
  }, _this);
};

_s2(Profile, "ZpOvj47KCDv4EW5BIUHQHDAsr3M=", false, function () {
  return [components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"]];
});

_c4 = Profile;

var Login = function Login(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], _objectSpread(_objectSpread({
    href: "http://localhost:8080/authorize/github"
  }, props), {}, {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], {
      width: "100px",
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Text"], {
        children: "Sign In"
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 103,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Text"], {
        marginTop: "4px",
        marginLeft: "7px",
        children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(react_icons_fa__WEBPACK_IMPORTED_MODULE_4__["FaGithub"], {
          fontSize: "1.15rem"
        }, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 105,
          columnNumber: 11
        }, _this)
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 104,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 102,
      columnNumber: 7
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 101,
    columnNumber: 5
  }, _this);
};

_c5 = Login;

var ProfileMenu = function ProfileMenu(props) {
  _s3();

  var _useAuth2 = Object(components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"])(),
      user = _useAuth2.user,
      handleLogout = _useAuth2.handleLogout;

  var profile = user || {};
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Menu"], {
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuButton"], {
        as: _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Button"],
        rightIcon: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(react_icons_md__WEBPACK_IMPORTED_MODULE_5__["MdArrowDropDown"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 119,
          columnNumber: 44
        }, _this),
        children: profile.username
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 119,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuList"], {
        children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuDivider"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 123,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Box"], {
          paddingX: "12px",
          children: ["Dark mode", /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_ThemeSwitch__WEBPACK_IMPORTED_MODULE_6__["default"], {
            marginX: "7px"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 126,
            columnNumber: 13
          }, _this)]
        }, void 0, true, {
          fileName: _jsxFileName,
          lineNumber: 124,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuDivider"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 128,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuGroup"], {
          children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            children: "My profile"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 130,
            columnNumber: 13
          }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            children: "Settings "
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 131,
            columnNumber: 13
          }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            onClick: handleLogout,
            children: "Logout"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 132,
            columnNumber: 13
          }, _this)]
        }, void 0, true, {
          fileName: _jsxFileName,
          lineNumber: 129,
          columnNumber: 11
        }, _this)]
      }, void 0, true, {
        fileName: _jsxFileName,
        lineNumber: 122,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 118,
      columnNumber: 7
    }, _this)
  }, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 117,
    columnNumber: 5
  }, _this);
};

_s3(ProfileMenu, "mSW+RoajZBiJZe2sByCSxGQKiOI=", false, function () {
  return [components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"]];
});

_c6 = ProfileMenu;
/* harmony default export */ __webpack_exports__["default"] = (Header);

var _c, _c2, _c3, _c4, _c5, _c6;

$RefreshReg$(_c, "Header");
$RefreshReg$(_c2, "Navigation");
$RefreshReg$(_c3, "NavigationItem");
$RefreshReg$(_c4, "Profile");
$RefreshReg$(_c5, "Login");
$RefreshReg$(_c6, "ProfileMenu");

;
    var _a, _b;
    // Legacy CSS implementations will `eval` browser code in a Node.js context
    // to extract CSS. For backwards compatibility, we need to check we're in a
    // browser context before continuing.
    if (typeof self !== 'undefined' &&
        // AMP / No-JS mode does not inject these helpers:
        '$RefreshHelpers$' in self) {
        var currentExports = module.__proto__.exports;
        var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;
        // This cannot happen in MainTemplate because the exports mismatch between
        // templating and execution.
        self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.i);
        // A module can be accepted automatically based on its exports, e.g. when
        // it is a Refresh Boundary.
        if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {
            // Save the previous exports on update so we can compare the boundary
            // signatures.
            module.hot.dispose(function (data) {
                data.prevExports = currentExports;
            });
            // Unconditionally accept an update to this module, we'll check if it's
            // still a Refresh Boundary later.
            module.hot.accept();
            // This field is set when the previous version of this module was a
            // Refresh Boundary, letting us know we need to check for invalidation or
            // enqueue an update.
            if (prevExports !== null) {
                // A boundary can become ineligible if its exports are incompatible
                // with the previous exports.
                //
                // For example, if you add/remove/change exports, we'll want to
                // re-execute the importing modules, and force those components to
                // re-render. Similarly, if you convert a class component to a
                // function, we want to invalidate the boundary.
                if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {
                    module.hot.invalidate();
                }
                else {
                    self.$RefreshHelpers$.scheduleUpdate();
                }
            }
        }
        else {
            // Since we just executed the code for the module, it's possible that the
            // new exports made it ineligible for being a boundary.
            // We only care about the case when we were _previously_ a boundary,
            // because we already accepted this update (accidental side effect).
            var isNoLongerABoundary = prevExports !== null;
            if (isNoLongerABoundary) {
                module.hot.invalidate();
            }
        }
    }

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../../node_modules/next/dist/compiled/webpack/harmony-module.js */ "./node_modules/next/dist/compiled/webpack/harmony-module.js")(module)))

/***/ })

})
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL2NvbXBvbmVudHMvbGF5b3V0L0hlYWRlci5qcyJdLCJuYW1lcyI6WyJIZWFkZXIiLCJwcm9wcyIsImJnQ29sb3IiLCJ1c2VDb2xvck1vZGVWYWx1ZSIsImNvbG9yIiwiY29uc29sZSIsImxvZyIsInNtIiwiYmFzZSIsIm91dGxpbmUiLCJOYXZpZ2F0aW9uIiwiTmF2aWdhdGlvbkl0ZW0iLCJocmVmIiwibGFiZWwiLCJQcm9maWxlIiwidXNlQXV0aCIsInRva2VuIiwidmlldyIsIkxvZ2luIiwiUHJvZmlsZU1lbnUiLCJ1c2VyIiwiaGFuZGxlTG9nb3V0IiwicHJvZmlsZSIsIkJ1dHRvbiIsInVzZXJuYW1lIl0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQWlCQTtBQUNBO0FBQ0E7QUFFQTtBQUNBOztBQUVBLElBQU1BLE1BQU0sR0FBRyxTQUFUQSxNQUFTLENBQUNDLEtBQUQsRUFBVztBQUFBOztBQUN4QixNQUFNQyxPQUFPLEdBQUdDLDBFQUFpQixDQUFDLFNBQUQsRUFBWSxVQUFaLENBQWpDO0FBQ0EsTUFBTUMsS0FBSyxHQUFHRCwwRUFBaUIsQ0FBQyxPQUFELEVBQVUsT0FBVixDQUEvQjtBQUNBRSxTQUFPLENBQUNDLEdBQVIsQ0FBWSxRQUFaO0FBRUEsc0JBQ0UscUVBQUMscUVBQUQ7QUFDRSxVQUFNLEVBQUMsR0FEVDtBQUVFLFVBQU0sRUFBRTtBQUFFQyxRQUFFLEVBQUUsUUFBTjtBQUFnQkMsVUFBSSxFQUFFO0FBQXRCLEtBRlY7QUFHRSxNQUFFLEVBQUVOLE9BSE47QUFJRSxTQUFLLEVBQUVFLEtBSlQ7QUFLRSxVQUFNLEVBQUMsSUFMVDtBQU1FLFlBQVEsRUFBQztBQU5YLEtBT01ILEtBUE47QUFBQSwyQkFTRSxxRUFBQyxtRUFBRDtBQUNFLG1CQUFhLEVBQUU7QUFBRU0sVUFBRSxFQUFFLEtBQU47QUFBYUMsWUFBSSxFQUFFO0FBQW5CLE9BRGpCO0FBRUUs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QUE7QUFBQTtBQUFBLGlCQUFuQztBQUFBLGtCQUNHRCxPQUFPLENBQUNFO0FBRFg7QUFBQTtBQUFBO0FBQUE7QUFBQSxlQURGLGVBSUUscUVBQUMseURBQUQ7QUFBQSxnQ0FDRSxxRUFBQyw0REFBRDtBQUFBO0FBQUE7QUFBQTtBQUFBLGlCQURGLGVBRUUscUVBQUMsb0RBQUQ7QUFBSyxrQkFBUSxFQUFDLE1BQWQ7QUFBQSwrQ0FFRSxxRUFBQyxxRUFBRDtBQUFhLG1CQUFPLEVBQUM7QUFBckI7QUFBQTtBQUFBO0FBQUE7QUFBQSxtQkFGRjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsaUJBRkYsZUFNRSxxRUFBQyw0REFBRDtBQUFBO0FBQUE7QUFBQTtBQUFBLGlCQU5GLGVBT0UscUVBQUMsMERBQUQ7QUFBQSxrQ0FDRSxxRUFBQyx5REFBRDtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxtQkFERixlQUVFLHFFQUFDLHlEQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLG1CQUZGLGVBR0UscUVBQUMseURBQUQ7QUFBVSxtQkFBTyxFQUFFSCxZQUFuQjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxtQkFIRjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsaUJBUEY7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLGVBSkY7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBREY7QUFBQTtBQUFBO0FBQUE7QUFBQSxXQURGO0FBc0JELENBMUJEOztJQUFNRixXO1VBQzJCSiwrRDs7O01BRDNCSSxXO0FBNEJTbkIscUVBQWYiLCJmaWxlIjoic3RhdGljL3dlYnBhY2svcGFnZXMvaW5kZXguZDUyYjdjYjAzMDNmYTY0MGMyMTUuaG90LXVwZGF0ZS5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7XG4gIEZsZXgsXG4gIEJveCxcbiAgSGVhZGluZyxcbiAgTGluayxcbiAgQnV0dG9uLFxuICBUZXh0LFxuICBNZW51LFxuICBNZW51QnV0dG9uLFxuICBNZW51SXRlbSxcbiAgTWVudUdyb3VwLFxuICBNZW51TGlzdCxcbiAgTWVudURpdmlkZXIsXG4gIHVzZUNvbG9yTW9kZVZhbHVlLFxuICB1c2VTdGF0ZSxcbiAgdXNlRWZmZWN0XG59IGZyb20gJ0BjaGFrcmEtdWkvcmVhY3QnXG5pbXBvcnQgeyBDb250YWluZXIsIENvbnRlbnQgfSBmcm9tICdjb21wb25lbnRzL2xheW91dC9Db250YWluZXInXG5pbXBvcnQgeyBGYUdpdGh1YiB9IGZyb20gJ3JlYWN0LWljb25zL2ZhJ1xuaW1wb3J0IHsgTWRBcnJvd0Ryb3BEb3duIH0gZnJvbSAncmVhY3QtaWNvbnMvbWQnXG5cbmltcG9ydCBUaGVtZVN3aXRjaCBmcm9tICdjb21wb25lbnRzL2xheW91dC9UaGVtZVN3aXRjaCdcbmltcG9ydCB7IHVzZUF1dGggfSBmcm9tICdjb21wb25lbnRzL0F1dGhQcm92aWRlcidcblxuY29uc3QgSGVhZGVyID0gKHByb3BzKSA9PiB7XG4gIGNvbnN0IGJnQ29sb3IgPSB1c2VDb2xvck1vZGVWYWx1ZSgnZ3JheS41MCcsICdncmF5LjkwMCcpXG4gIGNvbnN0IGNvbG9yID0gdXNlQ29sb3JNb2RlVmFsdWUoJ2JsYWNrJywgJ3doaXRlJylcbiAgY29uc29sZS5sb2coJ2hlYWRlcicpXG5cbiAgcmV0dXJuIChcbiAgICA8Q29udGFpbmVyXG4gICAgICB6SW5kZXg9XCIxXCJcbiAgICAgIGhlaWdodD17eyBzbTogJzQuNXJlbScsIGJhc2U6ICdhdXRvJyB9fVxuICAgICAgYmc9e2JnQ29sb3J9XG4gICAgICBjb2xvcj17Y29sb3J9XG4gICAgICBzaGFkb3c9XCJzbVwiXG4gICAgICBwYWRkaW5nWD1cIjM3cHhcIlxuICAgICAgey4uLnByb3BzfVxuICAgID5cbiAgICAgIDxDb250ZW50XG4gICAgICAgIGZsZXhEaXJlY3Rpb249e3sgc206ICdyb3cnLCBiYXNlOiAnY29sdW1uJyB9fVxuICAgICAgICBqdXN0aWZ5Q29udGVudD1cInNwYWNlLWJldHdlZW5cIlxuICAgICAgICBhbGlnbkl0ZW1zPVwiY2VudGVyXCJcbiAgICAgID5cbiAgICAgICAgPEJveFxuICAgICAgICAgIHdpZHRoPXt7IHNtOiAnMTAwcHgnLCBiYXNlOiAnYXV0bycgfX1cbiAgICAgICAgICBwYWRkaW5nWT17eyBzbTogJzBweCcsIGJhc2U6ICc3cHgnIH19XG4gICAgICAgID5cbiAgICAgICAgICA8TGluayBocmVmPVwiL1wiIF9mb2N1cz17eyBvdXRsaW5lOiAwIH19PlxuICAgICAgICAgICAgPEhlYWRpbmcgZm9udFNpemU9XCIxLjVyZW1cIiBwYWRkaW5nUmlnaHQ9XCIwcHhcIj5cbiAgICAgICAgICAgICAgSHViXG4gICAgICAgICAgICA8L0hlYWRpbmc+XG4gICAgICAgICAgPC9MaW5rPlxuICAgICAgICA8L0JveD5cbiAgICAgICAgPE5hdmlnYXRpb24gcGFkZGluZ1k9e3sgc206ICcwcHgnLCBiYXNlOiAnN3B4JyB9fSAvPlxuICAgICAgICA8UHJvZmlsZSBwYWRkaW5nWT17eyBzbTogJzBweCcsIGJhc2U6ICc3cHgnIH19IC8+XG4gICAgICA8L0NvbnRlbnQ+XG4gICAgPC9Db250YWluZXI+XG4gIClcbn1cblxuY29uc3QgTmF2aWdhdGlvbiA9IChwcm9wcykgPT4ge1xuICByZXR1cm4gKFxuICAgIDxGbGV4IHsuLi5wcm9wc30+XG4gICAgICA8TmF2aWdhdGlvbkl0ZW0gbGFiZWw9XCJBYm91dFwiIGhyZWY9XCIvYWJvdXRcIiAvPlxuICAgICAgPE5hdmlnYXRpb25JdGVtIGxhYmVsPVwiRG9jc1wiIGhyZWY9XCIvZG9jc1wiIC8+XG4gICAgICA8TmF2aWdhdGlvbkl0ZW0gbGFiZWw9XCJFeHBsb3JlXCIgaHJlZj1cIi9leHBsb3JlXCIgLz5cbiAgICAgIDxOYXZpZ2F0aW9uSXRlbSBsYWJlbD1cIlN1cHBvcnRcIiBocmVmPVwiaHR0cHM6Ly9wYW5kYS1sYW5nLm9yZy9zdXBwb3J0L1wiIC8+XG4gICAgPC9GbGV4PlxuICApXG59XG5cbmNvbnN0IE5hdmlnYXRpb25JdGVtID0gKHByb3BzKSA9PiB7XG4gIHJldHVybiAoXG4gICAgPExpbmtcbiAgICAgIGhyZWY9e3Byb3BzLmhyZWZ9XG4gICAgICBmb250V2VpZ2h0PVwiYm9sZFwiXG4gICAgICBwYWRkaW5nWD1cIjEzcHhcIlxuICAgICAgX2ZvY3VzPXt7IG91dGxpbmU6IDAgfX1cbiAgICAgIHsuLi5wcm9wc31cbiAgICA+XG4gICAgICB7cHJvcHMubGFiZWx9XG4gICAgPC9MaW5rPlxuICApXG59XG5cbmNvbnN0IFByb2ZpbGUgPSAocHJvcHMpID0+IHtcbiAgY29uc3QgeyB0b2tlbiB9ID0gdXNlQXV0aCgpXG5cbiAgY29uc3QgdmlldyA9IHRva2VuID8gPFByb2ZpbGVNZW51Lz4gOiA8TG9naW4gLz5cbiAgY29uc29sZS5sb2coJ3Byb2ZpbGUnKVxuICByZXR1cm4gKFxuICAgIDxGbGV4IGFsaWduSXRlbXM9XCJjZW50ZXJcIiBkaXNwbGF5PXt7IHNtOiAnZmxleCcsIGJhc2U6ICdub25lJyB9fSB7Li4ucHJvcHN9PlxuICAgICAge3ZpZXd9XG4gICAgPC9GbGV4PlxuICApXG59XG5cbmNvbnN0IExvZ2luID0gKHByb3BzKSA9PiB7XG4gIHJldHVybiAoXG4gICAgPExpbmsgaHJlZj1cImh0dHA6Ly9sb2NhbGhvc3Q6ODA4MC9hdXRob3JpemUvZ2l0aHViXCIgey4uLnByb3BzfT5cbiAgICAgIDxGbGV4IHdpZHRoPVwiMTAwcHhcIj5cbiAgICAgICAgPFRleHQ+U2lnbiBJbjwvVGV4dD5cbiAgICAgICAgPFRleHQgbWFyZ2luVG9wPVwiNHB4XCIgbWFyZ2luTGVmdD1cIjdweFwiPlxuICAgICAgICAgIDxGYUdpdGh1YiBmb250U2l6ZT1cIjEuMTVyZW1cIiAvPlxuICAgICAgICA8L1RleHQ+XG4gICAgICA8L0ZsZXg+XG4gICAgPC9MaW5rPlxuICApXG59XG5cbmNvbnN0IFByb2ZpbGVNZW51ID0gKHByb3BzKSA9PiB7XG4gIGNvbnN0IHsgdXNlciwgaGFuZGxlTG9nb3V0IH0gPSB1c2VBdXRoKClcbiAgY29uc3QgcHJvZmlsZSA9IHVzZXIgfHwge31cblxuICByZXR1cm4gKFxuICAgIDxGbGV4PlxuICAgICAgPE1lbnU+XG4gICAgICAgIDxNZW51QnV0dG9uIGFzPXtCdXR0b259IHJpZ2h0SWNvbj17PE1kQXJyb3dEcm9wRG93biAvPn0+XG4gICAgICAgICAge3Byb2ZpbGUudXNlcm5hbWV9XG4gICAgICAgIDwvTWVudUJ1dHRvbj5cbiAgICAgICAgPE1lbnVMaXN0PlxuICAgICAgICAgIDxNZW51RGl2aWRlciAvPlxuICAgICAgICAgIDxCb3ggcGFkZGluZ1g9XCIxMnB4XCI+XG4gICAgICAgICAgICBEYXJrIG1vZGVcbiAgICAgICAgICAgIDxUaGVtZVN3aXRjaCBtYXJnaW5YPVwiN3B4XCIgLz5cbiAgICAgICAgICA8L0JveD5cbiAgICAgICAgICA8TWVudURpdmlkZXIgLz5cbiAgICAgICAgICA8TWVudUdyb3VwPlxuICAgICAgICAgICAgPE1lbnVJdGVtPk15IHByb2ZpbGU8L01lbnVJdGVtPlxuICAgICAgICAgICAgPE1lbnVJdGVtPlNldHRpbmdzIDwvTWVudUl0ZW0+XG4gICAgICAgICAgICA8TWVudUl0ZW0gb25DbGljaz17aGFuZGxlTG9nb3V0fT5Mb2dvdXQ8L01lbnVJdGVtPlxuICAgICAgICAgIDwvTWVudUdyb3VwPlxuICAgICAgICA8L01lbnVMaXN0PlxuICAgICAgPC9NZW51PlxuICAgIDwvRmxleD5cbiAgKVxufVxuXG5leHBvcnQgZGVmYXVsdCBIZWFkZXJcbiJdLCJzb3VyY2VSb290IjoiIn0=