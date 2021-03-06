webpackHotUpdate_N_E("pages/authorized",{

/***/ "./src/components/AuthProvider.js":
/*!****************************************!*\
  !*** ./src/components/AuthProvider.js ***!
  \****************************************/
/*! exports provided: AuthProvider, useAuth */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthProvider", function() { return AuthProvider; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "useAuth", function() { return useAuth; });
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ "./node_modules/react/jsx-dev-runtime.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/defineProperty */ "./node_modules/@babel/runtime/helpers/esm/defineProperty.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var universal_cookie__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! universal-cookie */ "./node_modules/universal-cookie/es6/index.js");
/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! axios */ "./node_modules/axios/index.js");
/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(axios__WEBPACK_IMPORTED_MODULE_4__);



var _jsxFileName = "J:\\Java\\Spring\\hub\\hub-frontend\\src\\components\\AuthProvider.js",
    _this = undefined,
    _s = $RefreshSig$(),
    _s2 = $RefreshSig$();

function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { Object(J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_1__["default"])(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }




var AuthContext = /*#__PURE__*/Object(react__WEBPACK_IMPORTED_MODULE_2__["createContext"])();
var cookies = new universal_cookie__WEBPACK_IMPORTED_MODULE_3__["default"]();

var AuthProvider = function AuthProvider(_ref) {
  _s();

  var children = _ref.children;

  var _useState = Object(react__WEBPACK_IMPORTED_MODULE_2__["useState"])(),
      token = _useState[0],
      setToken = _useState[1];

  var _useState2 = Object(react__WEBPACK_IMPORTED_MODULE_2__["useState"])(),
      user = _useState2[0],
      setUser = _useState2[1];

  Object(react__WEBPACK_IMPORTED_MODULE_2__["useEffect"])(function () {
    console.log(token);

    if (token) {
      fetchUser();
    }
  });

  var handleLogin = function handleLogin(jwt) {
    cookies.set('jwt', jwt, {
      path: '/',
      maxAge: 60 * 60 * 24 * 30,
      // 30 days
      sameSite: 'lax'
    });
    setToken(jwt);
  };

  var handleLogout = function handleLogout() {
    cookies.remove('jwt');
    setUser(undefined);
    setToken(undefined);
  };

  var handleRequest = function handleRequest(route, options) {
    return axios__WEBPACK_IMPORTED_MODULE_4___default.a.get("http://localhost:8080".concat(route), _objectSpread({
      headers: {
        Authorization: "Bearer ".concat(token)
      }
    }, options));
  };

  var fetchUser = function fetchUser() {
    handleRequest('/user').then(function (response) {
      setUser(response.data);
    })["catch"](function (error) {
      var _error$data;

      console.log(error);

      if ((error === null || error === void 0 ? void 0 : (_error$data = error.data) === null || _error$data === void 0 ? void 0 : _error$data.status) >= 400) {
        handleLogout();
      }
    });
  };

  var context = {
    token: token,
    user: user,
    handleLogin: handleLogin,
    handleLogout: handleLogout,
    handleRequest: handleRequest
  };
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__["jsxDEV"])(AuthContext.Provider, {
    value: context,
    children: children
  }, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 64,
    columnNumber: 10
  }, _this);
};

_s(AuthProvider, "NBHE/9HkjsDSVFH75XjEPQ1DHtc=");

_c = AuthProvider;

var useAuth = function useAuth() {
  _s2();

  return Object(react__WEBPACK_IMPORTED_MODULE_2__["useContext"])(AuthContext);
};

_s2(useAuth, "gDsCjeeItUuvgOWf1v4qoK9RF6k=");



var _c;

$RefreshReg$(_c, "AuthProvider");

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

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../node_modules/next/dist/compiled/webpack/harmony-module.js */ "./node_modules/next/dist/compiled/webpack/harmony-module.js")(module)))

/***/ })

})
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL2NvbXBvbmVudHMvQXV0aFByb3ZpZGVyLmpzIl0sIm5hbWVzIjpbIkF1dGhDb250ZXh0IiwiY3JlYXRlQ29udGV4dCIsImNvb2tpZXMiLCJDb29raWVzIiwiQXV0aFByb3ZpZGVyIiwiY2hpbGRyZW4iLCJ1c2VTdGF0ZSIsInRva2VuIiwic2V0VG9rZW4iLCJ1c2VyIiwic2V0VXNlciIsInVzZUVmZmVjdCIsImNvbnNvbGUiLCJsb2ciLCJmZXRjaFVzZXIiLCJoYW5kbGVMb2dpbiIsImp3dCIsInNldCIsInBhdGgiLCJtYXhBZ2UiLCJzYW1lU2l0ZSIsImhhbmRsZUxvZ291dCIsInJlbW92ZSIsInVuZGVmaW5lZCIsImhhbmRsZVJlcXVlc3QiLCJyb3V0ZSIsIm9wdGlvbnMiLCJheGlvcyIsImdldCIsImhlYWRlcnMiLCJBdXRob3JpemF0aW9uIiwidGhlbiIsInJlc3BvbnNlIiwiZGF0YSIsImVycm9yIiwic3RhdHVzIiwiY29udGV4dCIsInVzZUF1dGgiLCJ1c2VDb250ZXh0Il0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQUNBO0FBQ0E7QUFFQSxJQUFNQSxXQUFXLGdCQUFHQywyREFBYSxFQUFqQztBQUNBLElBQU1DLE9BQU8sR0FBRyxJQUFJQyx3REFBSixFQUFoQjs7QUFFQSxJQUFNQyxZQUFZLEdBQUcsU0FBZkEsWUFBZSxPQUFrQjtBQUFBOztBQUFBLE1BQWZDLFFBQWUsUUFBZkEsUUFBZTs7QUFBQSxrQkFDWEMsc0RBQVEsRUFERztBQUFBLE1BQzlCQyxLQUQ4QjtBQUFBLE1BQ3ZCQyxRQUR1Qjs7QUFBQSxtQkFFYkYsc0RBQVEsRUFGSztBQUFBLE1BRTlCRyxJQUY4QjtBQUFBLE1BRXhCQyxPQUZ3Qjs7QUFJckNDLHlEQUFTLENBQUMsWUFBTTtBQUNkQyxXQUFPLENBQUNDLEdBQVIsQ0FBWU4sS0FBWjs7QUFDQSxRQUFJQSxLQUFKLEVBQVc7QUFDVE8sZUFBUztBQUNWO0FBQ0YsR0FMUSxDQUFUOztBQU9BLE1BQU1DLFdBQVcsR0FBRyxTQUFkQSxXQUFjLENBQUNDLEdBQUQsRUFBUztBQUMzQmQsV0FBTyxDQUFDZSxHQUFSLENBQVksS0FBWixFQUFtQkQsR0FBbkIsRUFBd0I7QUFDdEJFLFVBQUksRUFBRSxHQURnQjtBQUV0QkMsWUFBTSxFQUFFLEtBQUssRUFBTCxHQUFVLEVBQVYsR0FBZSxFQUZEO0FBRUs7QUFDM0JDLGNBQVEsRUFBRTtBQUhZLEtBQXhCO0FBS0FaLFlBQVEsQ0FBQ1EsR0FBRCxDQUFSO0FBQ0QsR0FQRDs7QUFTQSxNQUFNSyxZQUFZLEdBQUcsU0FBZkEsWUFBZSxHQUFNO0FBQ3pCbkIsV0FBTyxDQUFDb0IsTUFBUixDQUFlLEtBQWY7QUFDQVosV0FBTyxDQUFDYSxTQUFELENBQVA7QUFDQWYsWUFBUSxDQUFDZSxTQUFELENBQVI7QUFDRCxHQUpEOztBQU1BLE1BQU1DLGFBQWEsR0FBRyxTQUFoQkEsYUFBZ0IsQ0FBQ0MsS0FBRCxFQUFRQyxPQUFSLEVBQW9CO0FBQ3hDLFdBQU9DLDRDQUFLLENBQUNDLEdBQU4sZ0NBQWtDSCxLQUFsQztBQUNMSSxhQUFPLEVBQUU7QUFDUEMscUJBQWEsbUJBQVl2QixLQUFaO0FBRE47QUFESixPQUlGbUIsT0FKRSxFQUFQO0FBTUQsR0FQRDs7QUFTQSxNQUFNWixTQUFTLEdBQUcsU0FBWkEsU0FBWSxHQUFNO0FBQ3RCVSxpQkFBYSxDQUFDLE9BQUQsQ0FBYixDQUNHTyxJQURILENBQ1EsVUFBQ0MsUUFBRCxFQUFjO0FBQ2xCdEIsYUFBTyxDQUFDc0IsUUFBUSxDQUFDQyxJQUFWLENBQVA7QUFDRCxLQUhILFdBSVMsVUFBQ0MsS0FBRCxFQUFXO0FBQUE7O0FBQ2hCdEIsYUFBTyxDQUFDQyxHQUFSLENBQVlxQixLQUFaOztBQUNBLFVBQUksQ0FBQUEsS0FBSyxTQUFMLElBQUFBLEtBQUssV0FBTCwyQkFBQUEsS0FBSyxDQUFFRCxJQUFQLDREQUFhRSxNQUFiLEtBQXVCLEdBQTNCLEVBQWdDO0FBQzlCZCxvQkFBWTtBQUNiO0FBQ0YsS0FUSDtBQVVELEdBWEQ7O0FBYUEsTUFBTWUsT0FBTyxHQUFHO0FBQ2Q3QixTQUFLLEVBQUxBLEtBRGM7QUFFZEUsUUFBSSxFQUFKQSxJQUZjO0FBR2RNLGVBQVcsRUFBWEEsV0FIYztBQUlkTSxnQkFBWSxFQUFaQSxZQUpjO0FBS2RHLGlCQUFhLEVBQWJBO0FBTGMsR0FBaEI7QUFRQSxzQkFBTyxxRUFBQyxXQUFELENBQWEsUUFBYjtBQUFzQixTQUFLLEVBQUVZLE9BQTdCO0FBQUEsY0FBdUMvQjtBQUF2QztBQUFBO0FBQUE7QUFBQTtBQUFBLFdBQVA7QUFDRCxDQXpERDs7R0FBTUQsWTs7S0FBQUEsWTs7QUEyRE4sSUFBTWlDLE9BQU8sR0FBRyxTQUFWQSxPQUFVO0FBQUE7O0FBQUEsU0FBTUMsd0RBQVUsQ0FBQ3RDLFdBQUQsQ0FBaEI7QUFBQSxDQUFoQjs7SUFBTXFDLE87O0FBRU4iLCJmaWxlIjoic3RhdGljL3dlYnBhY2svcGFnZXMvYXV0aG9yaXplZC5jYzE3YmZlZWVkZWI0Yzc2NTE0OS5ob3QtdXBkYXRlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgdXNlU3RhdGUsIGNyZWF0ZUNvbnRleHQsIHVzZUNvbnRleHQsIHVzZUVmZmVjdCB9IGZyb20gJ3JlYWN0J1xuaW1wb3J0IENvb2tpZXMgZnJvbSAndW5pdmVyc2FsLWNvb2tpZSdcbmltcG9ydCBheGlvcyBmcm9tICdheGlvcydcblxuY29uc3QgQXV0aENvbnRleHQgPSBjcmVhdGVDb250ZXh0KClcbmNvbnN0IGNvb2tpZXMgPSBuZXcgQ29va2llcygpXG5cbmNvbnN0IEF1dGhQcm92aWRlciA9ICh7IGNoaWxkcmVuIH0pID0+IHtcbiAgY29uc3QgW3Rva2VuLCBzZXRUb2tlbl0gPSB1c2VTdGF0ZSgpXG4gIGNvbnN0IFt1c2VyLCBzZXRVc2VyXSA9IHVzZVN0YXRlKClcblxuICB1c2VFZmZlY3QoKCkgPT4ge1xuICAgIGNvbnNvbGUubG9nKHRva2VuKVxuICAgIGlmICh0b2tlbikge1xuICAgICAgZmV0Y2hVc2VyKClcbiAgICB9XG4gIH0pXG5cbiAgY29uc3QgaGFuZGxlTG9naW4gPSAoand0KSA9PiB7XG4gICAgY29va2llcy5zZXQoJ2p3dCcsIGp3dCwge1xuICAgICAgcGF0aDogJy8nLFxuICAgICAgbWF4QWdlOiA2MCAqIDYwICogMjQgKiAzMCwgLy8gMzAgZGF5c1xuICAgICAgc2FtZVNpdGU6ICdsYXgnLFxuICAgIH0pXG4gICAgc2V0VG9rZW4oand0KVxuICB9XG5cbiAgY29uc3QgaGFuZGxlTG9nb3V0ID0gKCkgPT4ge1xuICAgIGNvb2tpZXMucmVtb3ZlKCdqd3QnKVxuICAgIHNldFVzZXIodW5kZWZpbmVkKVxuICAgIHNldFRva2VuKHVuZGVmaW5lZClcbiAgfVxuXG4gIGNvbnN0IGhhbmRsZVJlcXVlc3QgPSAocm91dGUsIG9wdGlvbnMpID0+IHtcbiAgICByZXR1cm4gYXhpb3MuZ2V0KGBodHRwOi8vbG9jYWxob3N0OjgwODAke3JvdXRlfWAsIHtcbiAgICAgIGhlYWRlcnM6IHtcbiAgICAgICAgQXV0aG9yaXphdGlvbjogYEJlYXJlciAke3Rva2VufWAsXG4gICAgICB9LFxuICAgICAgLi4ub3B0aW9ucyxcbiAgICB9KVxuICB9XG5cbiAgY29uc3QgZmV0Y2hVc2VyID0gKCkgPT4ge1xuICAgIGhhbmRsZVJlcXVlc3QoJy91c2VyJylcbiAgICAgIC50aGVuKChyZXNwb25zZSkgPT4ge1xuICAgICAgICBzZXRVc2VyKHJlc3BvbnNlLmRhdGEpXG4gICAgICB9KVxuICAgICAgLmNhdGNoKChlcnJvcikgPT4ge1xuICAgICAgICBjb25zb2xlLmxvZyhlcnJvcilcbiAgICAgICAgaWYgKGVycm9yPy5kYXRhPy5zdGF0dXMgPj0gNDAwKSB7XG4gICAgICAgICAgaGFuZGxlTG9nb3V0KClcbiAgICAgICAgfVxuICAgICAgfSlcbiAgfVxuXG4gIGNvbnN0IGNvbnRleHQgPSB7XG4gICAgdG9rZW4sXG4gICAgdXNlcixcbiAgICBoYW5kbGVMb2dpbixcbiAgICBoYW5kbGVMb2dvdXQsXG4gICAgaGFuZGxlUmVxdWVzdCxcbiAgfVxuXG4gIHJldHVybiA8QXV0aENvbnRleHQuUHJvdmlkZXIgdmFsdWU9e2NvbnRleHR9PntjaGlsZHJlbn08L0F1dGhDb250ZXh0LlByb3ZpZGVyPlxufVxuXG5jb25zdCB1c2VBdXRoID0gKCkgPT4gdXNlQ29udGV4dChBdXRoQ29udGV4dClcblxuZXhwb3J0IHsgQXV0aFByb3ZpZGVyLCB1c2VBdXRoIH1cbiJdLCJzb3VyY2VSb290IjoiIn0=